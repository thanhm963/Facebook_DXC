package com.example.facebook_api.Controller;

import com.example.facebook_api.Entity.Status;
import com.example.facebook_api.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/statusService")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/save")
    public Status saveStatus (@RequestBody Status status) {
        return statusService.saveStatus(status);
    }

    @GetMapping("/getAllStatus")
    public ArrayList<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

    @DeleteMapping("/delete/{statusID}")
    public ArrayList<Status> deleteStatus(@PathVariable("statusID") UUID statusID){
        ArrayList<Status> result = statusService.delteStatus(statusID);
        return result;
    }
}

