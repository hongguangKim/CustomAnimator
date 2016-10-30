CustomAnimator
================
 自定义了一个非常简单的一个带动画的Textview，TextView被加载时会从marginglef＝-100的开始向右移动加载。<br>
 此TextView用于RecyclerView的Holder中。<br>
 手动在RecyclerView中addItem或removeItem时会带有Scale的Animation来渲染UI。<br>
 
 Demo
================
![demo](https://raw.githubusercontent.com/hongguangKim/CustomAnimator/master/app2/DEMO/demo.png)

Gradle
----
build.gradle相关请参考 as below:
```
dependencies {
    compile 'jp.wasabeef:recyclerview-animators:2.2.4'
}
```

有关RecyclerView的itemview的添加可以extends上面包中的BasicAnimator，实现自己的动画。例如此例子中的as below：
```java
@Override
    protected void preAnimateRemoveImpl(RecyclerView.ViewHolder holder) {
                ViewCompat.setPivotY(holder.itemView, 0);
    }

    @Override
    protected void animateRemoveImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .scaleX(0)
                .scaleY(0)
                .setDuration(getRemoveDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }

    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.setScaleX(holder.itemView, 0);
        ViewCompat.setScaleY(holder.itemView, 0);
    }


    @Override
    protected void animateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .scaleX(1)
                .scaleY(1)
                .setDuration(getRemoveDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }
```
