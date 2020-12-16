package com.pj.jawaseom.listener;

import com.pj.jawaseom.PostInfo;

public interface OnPostListener {
    void onDelete(PostInfo postInfo);
    void onModify();
}
