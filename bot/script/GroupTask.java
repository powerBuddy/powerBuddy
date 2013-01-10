package org.powerbuddy.bot.script;

/**
 * User: Matt
 * Date: 1/5/13
 * Time: 11:52 PM
 */
public abstract class GroupTask extends Task{

    private final Task[] tasks;

    private long delay = 150;

    public GroupTask(final Task... tasks){
        this.tasks = tasks;
    }

    public void setDelay(final long delay){
        this.delay = delay;
    }

    @Override
    public void run() {
        if(tasks != null){
            for(final Task task : tasks){
                if(Script.isRunning()){
                    return;
                }
                //if(!Game.isLoggedIn()){
                // LoginService.start();
                //}
                if(task.validate()){
                    task.run();
                }
                Script.sleep(delay);
            }
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof GroupTask){
            return (hashCode() == o.hashCode());
        }
        return false;
    }

}
