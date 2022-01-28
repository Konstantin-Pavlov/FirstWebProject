public class SimpleMessageRenderer implements MessageRenderer {

    private final MessageProvider messageProvider;

    public SimpleMessageRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}
