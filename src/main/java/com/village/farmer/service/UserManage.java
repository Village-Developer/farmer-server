package com.village.farmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Users;
import com.village.farmer.model.request.UserEditRequest;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.model.response.UserGetResponse;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;
import com.village.farmer.statics.StatusStatic;

@Service
public class UserManage {

    @Autowired UserRepository userRepo;
    @Autowired CredentialRepository credRepo;
    
    public ResponseEntity<UserGetResponse> getUser(String username) {
        UserGetResponse res = new UserGetResponse();
        try {
            Credentials data = credRepo.findByUser(username);
            Users user = userRepo.findByCred(data);
            res.setData(user);
            res.setMsg(StatusStatic.MANAGE_USER_01);
        } catch (Exception e) {
            res.setMsg(e.getMessage());
        }
        return ResponseEntity
        		.status(StatusStatic.Status(res.getMsg()))
        		.body(res);
    }

    public ResponseEntity<GenericsResponse> editUser(String username, UserEditRequest request) {
        GenericsResponse res = new GenericsResponse();
        try {
            Credentials data = credRepo.findByUser(username);
            Users user = userRepo.findByCred(data);
            if(request.getAddr()!=null) {
            	user.setAddr(request.getAddr());
            }
            if(request.getFname()!=null) {
            	 user.setFname(request.getFname());
            }
            if(request.getLname()!=null) {
            	user.setLname(request.getLname());
            }
            if(request.getEmail()!=null) {
            	user.setMail(request.getEmail());
            }
            if(request.getTel()!=null) {
            	user.setTel(request.getTel());
            }
            userRepo.save(user);
            res.setMsg("Success");
        } catch (Exception e) {
            res.setMsg(e.getMessage());
        }
        return ResponseEntity
        		.status(StatusStatic.Status(res.getMsg()))
        		.body(res);
    }
}
