package com.source.service;

import java.util.List;

import com.source.entity.DscEntity;

public interface DscService {
	

	public DscEntity saveDsc(DscEntity dsc);
    public List<DscEntity>getAll();
    public DscEntity getDscById(Long id);
    public DscEntity updateDsc(DscEntity Dsc,Long id);
    public String deleteDsc(Long id);
}

