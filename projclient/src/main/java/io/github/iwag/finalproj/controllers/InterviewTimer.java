package io.github.iwag.finalproj.controllers;

public class InterviewTimer {

    private int initialSec;
    private Thread thread;
    private RunnableTimer runnable;

    class RunnableTimer implements Runnable {

        int time;
        private boolean interrupted;

        RunnableTimer() {
            time=0;
            interrupted = false;
        }

        @Override
        public void run() {
            while (!interrupted) {
                time++;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        int getTime() {
            return time;
        }

        public void setInterrupted(boolean interrupted) {
            this.interrupted = interrupted;
        }
    }

    public InterviewTimer(int initialSec) {
        this.initialSec = initialSec;
        runnable = new RunnableTimer();
        thread = new Thread(runnable);
    }

    public int left() {
        return initialSec - runnable.getTime();
    }

    public void start() {
        thread.start();
    }
}
