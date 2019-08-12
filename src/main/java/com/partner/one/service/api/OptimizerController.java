package com.partner.one.service.api;

import com.partner.one.service.models.CleanRequest;
import com.partner.one.service.models.CleanResponse;
import com.partner.one.service.util.Optimizer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptimizerController {

    @RequestMapping("/")
    public String index() {
        return "Hello Welcome to Server Partner One Cleaner Optimizer";
    }

    @RequestMapping(value = "/optimize", method = RequestMethod.POST)
    public List<CleanResponse> optimize(@RequestBody CleanRequest request) {
        return Optimizer.optimizeWorkforce(request);
    }
}
