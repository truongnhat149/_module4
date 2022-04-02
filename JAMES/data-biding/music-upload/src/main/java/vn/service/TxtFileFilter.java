package vn.service;

import java.io.File;
import java.io.FileFilter;

public class TxtFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (!pathname.isFile()) {
            return false;
        }

        if (pathname.getAbsolutePath().endsWith(".mp3")
        || pathname.getAbsolutePath().endsWith(".mp4")
        || pathname.getAbsolutePath().endsWith(".ogg")
        || pathname.getAbsolutePath().endsWith(".wav")
        ) {
            return true;
        }

        return false;
    }
}
