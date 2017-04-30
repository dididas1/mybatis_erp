package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.erp.dto.Title;

public interface TitleMapper {
	List<Title> selectTitleByAll();
	Title selectTitleByNo(Title title); 
	int insertTitleItem(Title title);
	int updateTitleItem(Title title);
	int deleteTitleItem(Title title);
}
