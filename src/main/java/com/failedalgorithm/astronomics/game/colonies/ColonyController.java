package com.failedalgorithm.astronomics.game.colonies;

import com.failedalgorithm.astronomics.game.colonies.requests.ColonyDeleteRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyReadRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyUpdateRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyCreateRequest;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colonies")
public class ColonyController
{

    //================================================================================
    // Injected Services
    //================================================================================
    @Autowired
    ColonyService service;


    //================================================================================
    // Endpoints
    //================================================================================

    //region Getters
    //-----------------------------------------
    @GetMapping
    public Iterable<Colony> getAllColonies()
    {
        return service.getAllColonies();
    }

    @GetMapping("/details")
    public ColonyReadResponse getColony(@RequestAttribute("userId") Long userId)
    {
        ColonyReadRequest request = new ColonyReadRequest();
        request.setUserId(userId);
        return service.getIndividualColony(request);
    }
    //-----------------------------------------
    //endregion

    //region Creators
    //-----------------------------------------
    @PostMapping("/found")
    public ColonyFoundationResponse foundNewColony(@RequestBody ColonyCreateRequest request,
                                                   @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.foundNewColony(request);
    }
    //-----------------------------------------
    //endregion

    //region Updaters
    //-----------------------------------------
    @PutMapping("/update")
    public ColonyUpdateResponse updateColony(@RequestBody ColonyUpdateRequest request,
                                             @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.updateColony(request);
    }
    //-----------------------------------------
    //endregion

    //region Deleters
    //-----------------------------------------
    @DeleteMapping("/delete")
    public ColonyDeleteResponse deleteColony(@RequestBody ColonyDeleteRequest request,
                                             @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.deleteColony(request);
    }
    //-----------------------------------------
    //endregion




}
