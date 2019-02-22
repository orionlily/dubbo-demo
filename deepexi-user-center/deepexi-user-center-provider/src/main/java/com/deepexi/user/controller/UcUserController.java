package com.deepexi.user.controller;

import com.deepexi.user.domain.vo.UcUser;
import com.deepexi.user.service.impl.UcUserService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.Arrays;

/**
 * @author Administrator
 * @date 2019/2/21
 */
@Controller
@Path("/api/v1/components")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UcUserController {

    @Autowired
    private UcUserService ucUserService;

    @GET
    @Path("/")
    public Payload getUcUserList(@QueryParam("page") @DefaultValue("1")  Integer page,
                                 @QueryParam("size") @DefaultValue("10")  Integer size,
                                 @QueryParam("username") @DefaultValue("")  String username,
                                 @QueryParam("usernumber") @DefaultValue("")  String usernumber,
                                 @QueryParam("nickname") @DefaultValue("")  String nickname,
                                 @QueryParam("eamil") @DefaultValue("")  String email){
        return new Payload(ucUserService.getUcUserList(page,size,username,usernumber,nickname,email));
    }

    @GET
    @Path("/{id}")
    public Payload getUcUserById(@PathParam(value = "id") String id){
        return new Payload(ucUserService.getUcUserById(id));
    }


    @DELETE
    @Path("/{ids}")
    public Payload deleteUcUserByIds(@PathParam(value = "ids") String ids){
        return new Payload(ucUserService.deleteUcUserByIds( Arrays.asList(ids.split(","))));
    }


    @PUT
    @Path("/{id}")
    public Payload updateUcUserById(UcUser ucUser){
        return new Payload(ucUserService.updateUcUserById(ucUser));
    }

    @POST
    @Path("/")
    public Payload addUcUser(UcUser ucUser){
        return new Payload(ucUserService.addUcUser(ucUser));
    }
}
