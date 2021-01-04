package com.souvenir_type.model;

import java.util.*;



public interface SouvenirTypeDAO_interface {
public void insert(SouvenirTypeVO soutVO);
public void update(SouvenirTypeVO soutVO);
public void delete(String sou_type_id);
public SouvenirTypeVO findByPrimaryKey(String sou_type_id);
public List<SouvenirTypeVO> getAll();
}
