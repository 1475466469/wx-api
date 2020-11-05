package com.github.niefy.modules.wx.service;

import com.github.niefy.modules.wx.entity.DataResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface VideoSourcesService {


    List<DataResult> GetVideoS(String VideoName) throws IOException;

}
