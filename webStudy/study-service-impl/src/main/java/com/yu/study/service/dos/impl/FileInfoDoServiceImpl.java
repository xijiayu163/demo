package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.FileInfoPo;
import com.yu.study.dos.FileInfoDo;
import com.yu.study.service.dos.FileInfoDoService;

@Service
public class FileInfoDoServiceImpl extends BaseDoServiceImpl<FileInfoDo,FileInfoPo> implements FileInfoDoService{

	@Override
	public String getIdentifierName() {
		return "fileInfoUid";
	}
}
