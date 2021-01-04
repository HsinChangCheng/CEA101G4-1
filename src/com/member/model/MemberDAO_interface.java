package com.member.model;

import java.util.List;
import java.util.Set;


public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public MemberVO findByPrimaryKey(String mem_id);
    public MemberVO findbyaccount(String mem_account);
    public List<MemberVO> getAll();
    public void delete(String mem_id);
    public void upDateStatus(MemberVO memVO);
    
//    public Set<MemberVO> getEmpsByDeptno(Integer deptno);

}
