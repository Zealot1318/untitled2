package pflb.homework.first;

public interface IMessage<T> {
    String getFrom();
    String getTo();
    T getContent();
}
