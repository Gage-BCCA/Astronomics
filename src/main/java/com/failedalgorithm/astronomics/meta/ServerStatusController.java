package com.failedalgorithm.astronomics.meta;

import com.failedalgorithm.astronomics.meta.Responses.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerStatusController
{

    @GetMapping
    public StatusResponse getServerStatus()
    {
        return new StatusResponse("Just a smoke test.");
    }
}
