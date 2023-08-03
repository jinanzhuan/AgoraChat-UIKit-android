package io.agora.chat.uikit.chathistory.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import io.agora.chat.ChatMessage;
import io.agora.chat.uikit.R;
import io.agora.chat.uikit.utils.EaseDateUtils;
import io.agora.chat.uikit.widget.chatrow.EaseChatRowVoice;


public class EaseChatRowHistoryVoice extends EaseChatRowVoice {

    public EaseChatRowHistoryVoice(Context context, boolean isSender) {
        super(context, isSender);
    }

    public EaseChatRowHistoryVoice(Context context, ChatMessage message, int position, Object adapter) {
        super(context, message, position, adapter);
    }

    @Override
    protected void onInflateView() {
        inflater.inflate(R.layout.ease_row_history_voice, this);
    }

    @Override
    public int getVoicePadding(int voiceLen) {
        return 0;
    }

    @Override
    public void startVoicePlayAnimation() {
        voiceImageView.setImageResource(R.drawable.voice_from_icon);
        voiceAnimation = (AnimationDrawable) voiceImageView.getDrawable();
        voiceAnimation.start();
    }

    @Override
    public void stopVoicePlayAnimation() {
        if (voiceAnimation != null) {
            voiceAnimation.stop();
        }
        voiceImageView.setImageResource(R.drawable.ease_chatfrom_voice_playing);
    }

    @Override
    public void setOtherTimestamp(ChatMessage preMessage) {
        timeStampView.setText(EaseDateUtils.getTimestampString(getContext(), new Date(message.getMsgTime())));
        timeStampView.setVisibility(View.VISIBLE);
    }
}
