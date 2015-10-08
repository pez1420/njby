package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.entity.Culture;
import com.njby.entity.Culture;
import com.njby.entity.search.SearchCulture;
import com.njby.service.impl.BaseServiceImpl;
import com.njby.service.CultureService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;
import com.njby.dao.CultureDao;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-05
 */
@Service
public class CultureServiceImpl extends BaseServiceImpl<Culture, String> implements CultureService{

    @Resource
    private CultureDao cultureDao;

    @Resource
    public void setBaseDao(CultureDao cultureDao){
        super.setBaseDao(cultureDao);
    }

    @Transactional(readOnly=true)
	public Page<Culture> findPage(Pageable pageable, SearchCulture searchCulture) {
		// 分页并计算出总页数
		List<Culture> Cultures = cultureDao.findPage(pageable, searchCulture);
		Page<Culture> page = new Page<Culture>(Cultures, pageable);
		return page;
	}

	@Transactional
	public void save(Culture entity) {
		super.save(entity);	
	}

	@Transactional(readOnly=true)
	public List<Culture> findList(Integer count) {
		return this.cultureDao.findList(count);
	}
}