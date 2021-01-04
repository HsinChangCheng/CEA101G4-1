package com.authorization.model;

import java.util.List;


public interface AuthorizationDAO_interface {
	public void insert(AuthorizationVO authorizationVO);
	public void update(AuthorizationVO authorizationVO);
    public void delete(String func_id);
    public AuthorizationVO findByPrimaryKey(String func_id);
    public List<AuthorizationVO> getAll();
}
