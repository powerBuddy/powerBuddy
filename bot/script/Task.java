package org.powerbuddy.bot.script;

/**
 * User: Matt
 * Date: 1/5/13
 * Time: 11:10 PM
 */
public abstract class Task implements Condition {

    public abstract void run();

    public void revoke(){
        Script.getTaskList().remove(this);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Task){
            return (hashCode() == o.hashCode());
        }
        return false;
    }

}
