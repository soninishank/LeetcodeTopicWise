package LLD.SOLID.LSP.Clients;

import LLD.SOLID.LSP.AbstractSocialMedia;

public class WhatsApp extends AbstractSocialMedia {
    @Override
    public void chatWithFriend() {

    }

    // @DontNotSupport
    @Override
    public void publishPost(Object post) {
        // does not applicable
        // so this class is not a substitute of parent class - AbstractSocialMedia
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}
