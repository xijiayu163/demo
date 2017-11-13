package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.FileInfoRelatePo;
import com.yu.study.dos.FileInfoRelateDo;
import com.yu.study.service.dos.FileInfoRelateDoService;

@Service
public class FileInfoRelateDoServiceImpl extends BaseDoServiceImpl<FileInfoRelateDo,FileInfoRelatePo> implements FileInfoRelateDoService{

	@Override
	public String getIdentifierName() {
		return "fileInfoRelateUid";
	}
}
