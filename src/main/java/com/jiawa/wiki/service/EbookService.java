package com.jiawa.wiki.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import com.jiawa.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dapeng
 * @create 2021-07-08 15:18
 */
@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike('%' + ebookReq.getName() + '%');
        List<Ebook> list = ebookMapper.selectByExample(ebookExample);
//        List<EbookResp> ebookRespList = new ArrayList<>();
//        for (Ebook ebook : list) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookRespList.add(ebookResp);
//        }
        List<EbookResp> ebookRespList = CopyUtil.copyList(list, EbookResp.class);
        return ebookRespList;
    }


}
