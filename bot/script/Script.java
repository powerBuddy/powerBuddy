package org.powerbuddy.bot.script;

import java.util.ArrayList;

/**
 * User: Matt
 * Date: 1/5/13
 * Time: 11:07 PM
 */
public abstract class Script implements Runnable {

    private static boolean running = false;

    private long delay = 150;

    private final static ArrayList<Task> TASKS = new ArrayList<>();

    private boolean reset = false;

    public abstract boolean setup();

    public void onFinish() {

    }

    public void reset() {
        reset = true;
    }

    public void provide(final Task task) {
        if (!TASKS.contains(task)) {
            TASKS.add(task);
        }
    }

    public void setDelay(final long delay) {
        this.delay = delay;
    }

    public static void sleep(final long time) {
        try {
            Thread.sleep(time);
        } catch (Exception ignored) {

        }
    }

    @Override
    public void run() {
        try {
            reset = false;
            synchronized (TASKS) {
                for (final Task task : getTaskList()) {
                    if (reset || !Script.isRunning()) {
                        return;
                    }
                    //if(!Game.isLoggedIn()){
                    // LoginService.start();
                    //}
                    if (task.validate()) {
                        task.run();
                    }
                    Script.sleep(delay);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }

    public static ArrayList<Task> getTaskList() {
        return TASKS;
    }

}
