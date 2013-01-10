package org.powerbuddy.bot.script;

/**
 * User: Matt
 * Date: 1/5/13
 * Time: 11:11 PM
 */
public abstract class LoopTask extends Task {

    public abstract int loop();

    @Override
    public void run(){

    }

    @Override
    public boolean validate(){
        if(!Script.isRunning()){
            return false;
        }
        //if(!Game.isLoggedIn()){
        // LoginService.start();
        //}
        final int time = loop();
        if(time <= 0){
            return false;
        }
        Script.sleep(time);
        return true;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof LoopTask){
            return (hashCode() == o.hashCode());
        }
        return false;
    }

}
