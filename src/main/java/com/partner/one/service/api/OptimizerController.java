package com.partner.one.service.api;

import com.partner.one.service.models.CleanRequest;
import com.partner.one.service.models.CleanResponse;
import com.partner.one.service.util.Optimizer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptimizerController {

    @GetMapping("/")
    public String index() {
        return "Hello Welcome to Server Partner One Cleaner Optimizer";
    }

    @PostMapping("/optimize")
    public List<CleanResponse> optimize(@RequestBody CleanRequest request) {
        return Optimizer.optimizeWorkforce(request);
    }
}
