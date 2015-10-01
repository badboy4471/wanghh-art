package com.whh.art.dao.mapper;

import com.whh.art.dao.model.BatchModel;

public interface BatchMapper {
	
	BatchModel insertBatch(BatchModel batch);
	
	void deleteBatch(int id);

}
