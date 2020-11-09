package com.github.niefy.modules.wx.service.impl;

import com.github.niefy.modules.wx.entity.DataResult;
import com.github.niefy.modules.wx.service.VideoSourcesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoSourcesServiceImpl implements VideoSourcesService {

    final  String Url="http://qishizihua.com/result.php?s=";
    @Override
    public List<DataResult> GetVideoS(String VideoName) throws IOException {
        Document doc = Jsoup.connect(Url+VideoName)

                .userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/69.0.3497.105 Mobile/15E148 Safari/605.1")
                .timeout(3000)
                .get();
        Elements resultLi = doc.select("li.my_fav_list_li"); // direct a after h3
        List<DataResult> results=new ArrayList<DataResult>();
        for (Element item:resultLi
        ) {
            DataResult re=   new DataResult();
            re.Url= item.select("a").attr("href");
            re.VideoName=item.select("a").text();
            re.text=item.select("label>span").text();
            results.add(re);
        }
      return  results;
    }
}
