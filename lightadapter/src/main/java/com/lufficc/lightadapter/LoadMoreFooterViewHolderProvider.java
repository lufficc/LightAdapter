package com.lufficc.lightadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by lufficc on 2016/8/31.
 */

public class LoadMoreFooterViewHolderProvider extends ViewHolderProvider<LoadMoreFooterModel, LoadMoreFooterViewHolderProvider.FooterViewHolder> {
    @Override
    public FooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FooterViewHolder(inflater.inflate(R.layout.footer_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LoadMoreFooterModel footerModel, FooterViewHolder viewHolder,int position) {
        if (footerModel.getInitState() != FooterState.STATE_INVALID) {
            viewHolder.state = footerModel.getInitState();
            footerModel.setInitState(FooterState.STATE_INVALID);
        }
        footerModel.setFooterViewHolder(viewHolder);
        viewHolder.onBind(footerModel);
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        private int state = FooterState.STATE_LOAD_MORE;

        TextView footerText;

        ProgressBar footerProgressBar;

        ImageView footerIcon;

        FooterViewHolder(View itemView) {
            super(itemView);
            footerText = (TextView) itemView.findViewById(R.id.footerText);
            footerProgressBar = (ProgressBar) itemView.findViewById(R.id.footerProgressBar);
            footerIcon = (ImageView) itemView.findViewById(R.id.footerIcon);
        }

        private void hideProgressBar() {
            if (footerProgressBar.getVisibility() != View.GONE) {
                footerProgressBar.setVisibility(View.GONE);
            }
        }

        private void showProgressBar() {
            if (footerProgressBar.getVisibility() != View.VISIBLE) {
                footerProgressBar.setVisibility(View.VISIBLE);
            }
        }

        private void hideIcon() {
            if (footerIcon.getVisibility() != View.GONE) {
                footerIcon.setVisibility(View.GONE);
            }
        }

        private void showIcon() {
            if (footerIcon.getVisibility() != View.VISIBLE) {
                footerIcon.setVisibility(View.VISIBLE);
            }
        }

        void onBind(LoadMoreFooterModel footerModel) {
            bindListener(footerModel);
            initItemViewState(footerModel);
            switch (state) {
                case FooterState.STATE_LOAD_MORE:
                    loadMoreView(footerModel.getLoadingMsg());
                    if (footerModel.getLoadMoreListener() != null) {
                        footerModel.getLoadMoreListener().onLoadMore();
                    }
                    break;
                case FooterState.STATE_NO_MORE:
                    noMoreView(footerModel.getNoMoreMsg(), footerModel.getNoMoreIcon());
                    break;
                case FooterState.STATE_ERROR:
                    errorView(footerModel.getErrorMsg(), footerModel.getErrorIcon());
                    break;
                case FooterState.STATE_GONE:
                    hideView();
                    break;
            }
        }

        private void initItemViewState(LoadMoreFooterModel footerModel) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.
                    LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setFullSpan(footerModel.isFullSpan());
            itemView.setLayoutParams(layoutParams);
        }

        private void bindListener(final LoadMoreFooterModel footerModel) {
            if (footerModel.getOnFooterClickListener() != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        footerModel.getOnFooterClickListener().onFooterClick(state);
                    }
                });
            }
        }

        private void errorView(String errorMsg, int errorIcon) {
            showView();
            hideProgressBar();
            showIcon();
            footerText.setText(errorMsg);
            footerIcon.setImageResource(errorIcon);
        }

        private void loadMoreView(String msg) {
            showView();
            hideIcon();
            showProgressBar();
            footerText.setText(msg);
        }

        private void noMoreView(String msg, int noMoreIcon) {
            showView();
            showIcon();
            hideProgressBar();
            footerText.setText(msg);
            footerIcon.setImageResource(noMoreIcon);
        }

        private void hideView() {
            if (itemView.getVisibility() != View.GONE) {
                itemView.setVisibility(View.GONE);
            }
        }

        private void showView() {
            if (itemView.getVisibility() != View.VISIBLE) {
                itemView.setVisibility(View.VISIBLE);
            }
        }

        /**
         * @param noMoreMsg  show when no more data
         *                   tell tha adapter there will not be data ,so the progress will hide,and the load more callback will not be invoked.
         * @param noMoreIcon
         */
        void noMoreData(String noMoreMsg, int noMoreIcon) {
            state = FooterState.STATE_NO_MORE;
            noMoreView(noMoreMsg, noMoreIcon);
        }

        /**
         * tell tha adapter there will be more data ,so the progress will show,and the load more callback will be invoked.
         */
        void canLoadMore(String loadMoreMsg) {
            state = FooterState.STATE_LOAD_MORE;
            loadMoreView(loadMoreMsg);
        }

        /**
         * set visibility gone
         */
        void hideFooter() {
            state = FooterState.STATE_GONE;
            hideView();
        }

        void errorOccur(String errorMsg, int errorIcon) {
            state = FooterState.STATE_ERROR;
            errorView(errorMsg, errorIcon);
        }
    }
}
