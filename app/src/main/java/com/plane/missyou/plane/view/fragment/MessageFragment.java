package com.plane.missyou.plane.view.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.github.bassaer.chatmessageview.models.Message;
import com.github.bassaer.chatmessageview.models.User;
import com.github.bassaer.chatmessageview.utils.ChatBot;
import com.github.bassaer.chatmessageview.views.ChatView;
import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;
import com.plane.missyou.plane.view.BaseView;

import java.util.Random;

import butterknife.BindView;


/**
 * Created by MissC on 2017/4/4.
 */

public class MessageFragment extends BaseFragment implements BaseView {

    @BindView(R.id.messages_chat_List)
    ChatView mChatView;
    private User me;
    private User you;

    public static BaseFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_2);
        //User name
        String myName = "MissChen";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_1);
        String yourName = "Miss";

        me = new User(myId, myName, myIcon);
        you = new User(yourId, yourName, yourIcon);

        mChatView.setRightBubbleColor(ContextCompat.getColor(getContext(), R.color.green500));
        mChatView.setLeftBubbleColor(Color.WHITE);
        mChatView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.blueGray500));
        mChatView.setSendButtonColor(ContextCompat.getColor(getContext(), R.color.cyan900));
        mChatView.setSendIcon(R.drawable.ic_action_send);
        mChatView.setRightMessageTextColor(Color.WHITE);
        mChatView.setLeftMessageTextColor(Color.BLACK);
        mChatView.setUsernameTextColor(Color.WHITE);
        mChatView.setSendTimeTextColor(Color.WHITE);
        mChatView.setDateSeparatorColor(Color.WHITE);
        mChatView.setInputTextHint("请输入...");
        mChatView.setMessageMarginTop(5);
        mChatView.setMessageMarginBottom(5);
    }

    @Override
    public void addListeners() {
        mChatView.setOnClickSendButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new message
                Message message = new Message.Builder()
                        .setUser(me)
                        .setRightMessage(true)
                        .setMessageText(mChatView.getInputText())
                        .hideIcon(true)
                        .build();
                //Set to chat view
                mChatView.send(message);
                //Reset edit text
                mChatView.setInputText("");

                //Receive message
                final Message receivedMessage = new Message.Builder()
                        .setUser(you)
                        .setRightMessage(false)
                        .hideIcon(false)
                        .setMessageText(ChatBot.talk(me.getName(), message.getMessageText()))
                        .build();

                // This is a demo bot
                // Return within 3 seconds
                int sendDelay = (new Random().nextInt(4) + 1) * 1000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mChatView.receive(receivedMessage);
                    }
                }, sendDelay);
            }

        });
    }


    @Override
    public void onEventMessage(EventMessage em) {

    }

    @Override
    public int inflaterRootView() {
        return R.layout.message_fragment;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(String errorStr) {

    }
}