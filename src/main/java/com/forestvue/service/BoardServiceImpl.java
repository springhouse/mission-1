package com.forestvue.service;

import com.forestvue.domain.BoardVO;
import com.forestvue.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register : " + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        return mapper.update(board)==1;
    }

    @Override
    public boolean remove(Long bno) {
        return mapper.delete(bno)==1;
    }

    @Override
    public List<BoardVO> getList() {
        return mapper.getList();
    }


}
