package vn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.model.Song;
import vn.model.SongForm;
import vn.service.ISongService;
import vn.service.SongServiceImpl;
import vn.service.TxtFileFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class UploadController implements FilenameFilter {

    private static ISongService songService = new SongServiceImpl();

    @GetMapping()
    public String index(Model model){
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    public ModelAndView saveSong(
            @ModelAttribute SongForm songForm, RedirectAttributes redirect
    )
    {

        MultipartFile multipartFile = songForm.getSound();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSound().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getNameSong(),
                songForm.getSinger(), songForm.getCategory(), fileName);
//        File dir = new File(fileUpload);
//        File[] mpFile = dir.listFiles(new TxtFileFilter());
//        for
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/song");
        redirect.addFlashAttribute("message", "Upload suscess");
        return modelAndView;
    }

    @Override
    public  boolean accept(File dir, String name) {
        if (name.endsWith(".mp3")) {
            return true;
        }
        return false;
    }
}
