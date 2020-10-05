package ru.itis.javalab.utils;

public class Task implements Runnable {

    private String url;

    private String folder;

    public Task(String url, String folder) {
        this.url = url;
        this.folder = folder;
    }

    @Override
    public void run() {
        Downloader.download(this.url,this.folder);
    }
}