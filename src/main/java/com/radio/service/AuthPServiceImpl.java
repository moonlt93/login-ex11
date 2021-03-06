package com.radio.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radio.domain.AuthPboardVO;
import com.radio.domain.Criteria;
import com.radio.mapper.AuthPMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//@Component
@Service
@AllArgsConstructor
@Log4j
public class AuthPServiceImpl implements AuthPService {
	
	private AuthPMapper mapper;
	
	/*
	//@Autowired
	public BoardServiceImpl(BoardMapper mapper) {
		this.mapper = mapper;
	}
	*/
	
	// mapper.read(33);
	
	@Override
	public void register(AuthPboardVO board) {
		mapper.insertSelectKey(board);
	}
	
	/*
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	*/
	
	@Override
	public List<AuthPboardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public AuthPboardVO get(Long bno) {
		return mapper.read(bno);
	}
	
	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public boolean modify(AuthPboardVO board) {
		return mapper.update(board) == 1;
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}






