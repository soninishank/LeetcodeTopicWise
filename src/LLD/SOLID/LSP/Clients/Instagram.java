package LLD.SOLID.LSP.Clients;

import LLD.SOLID.LSP.AbstractSocialMedia;

public class Instagram extends AbstractSocialMedia {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    // Not follows LSP
    @Override
    public void groupVideoCall(String... users) {
        //not applicable
    }
}
