package design.pattern.observer;

public class Button {

    public void onClick() {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public interface OnClickListener {
        void onClick(Button button);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
