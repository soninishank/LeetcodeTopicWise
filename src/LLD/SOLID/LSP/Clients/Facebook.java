package LLD.SOLID.LSP.Clients;

import LLD.SOLID.LSP.AbstractSocialMedia;

public class Facebook extends AbstractSocialMedia {

    // It supports LSP because all methods are supported, so it can be a replacement of parent class
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
