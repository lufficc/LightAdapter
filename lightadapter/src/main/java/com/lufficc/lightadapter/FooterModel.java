package com.lufficc.lightadapter;

import android.support.annotation.DrawableRes;

/**
 * Created by lufficc on 2016/8/31.
 */

public class FooterModel {
    private String noMoreMsg;
    private String loadingMsg;
    private String errorMsg;
    @DrawableRes
    private int noMoreIcon = R.mipmap.ic_success;
    @DrawableRes
    private int errorIcon = R.mipmap.ic_error;
    private FooterViewHolderProvider.FooterViewHolder footerViewHolder;

    @DrawableRes
    public int getErrorIcon() {
        return errorIcon;
    }

    public void setErrorIcon(@DrawableRes int errorIcon) {
        this.errorIcon = errorIcon;
    }

    @DrawableRes
    public int getNoMoreIcon() {
        return noMoreIcon;
    }

    public void setNoMoreIcon(@DrawableRes int noMoreIcon) {
        this.noMoreIcon = noMoreIcon;
    }

    public void setLoadMoreListener(LoadMoreListener listener) {
        if (footerViewHolder != null)
            footerViewHolder.setLoadMoreListener(listener);
    }


    FooterViewHolderProvider.FooterViewHolder getFooterViewHolder() {
        return footerViewHolder;
    }

    void setFooterViewHolder(FooterViewHolderProvider.FooterViewHolder footerViewHolder) {
        this.footerViewHolder = footerViewHolder;
    }

    public String getLoadingMsg() {
        return loadingMsg;
    }

    public void setLoadingMsg(String loadingMsg) {
        this.loadingMsg = loadingMsg;
    }

    public String getNoMoreMsg() {
        return noMoreMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setNoMoreMsg(String noMoreMsg) {
        this.noMoreMsg = noMoreMsg;
    }

    public void noMoreData() {
        if (footerViewHolder != null) {
            footerViewHolder.noMoreData(noMoreMsg, noMoreIcon);
        }
    }


    public void errorOccur() {
        if (footerViewHolder != null) {
            footerViewHolder.errorOccur(noMoreMsg, errorIcon);
        }
    }

    /**
     * tell tha adapter there will be more data ,so the progress will show,and the load more callback will be invoked.
     */
    public void canLoadMore() {
        if (footerViewHolder != null) {
            footerViewHolder.canLoadMore(loadingMsg);
        }
    }

    /**
     * set visibility gone
     */
    public void hideFooter() {
        if (footerViewHolder != null) {
            footerViewHolder.hideFooter();
        }
    }

    public interface LoadMoreListener {
        void onLoadMore();
    }
}
