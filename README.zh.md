![](https://img.shields.io/badge/%E4%B8%AD%E6%96%87-inactive?style=for-the-badge&logo=google-translate)
[![](https://img.shields.io/badge/English-informational?style=for-the-badge&logo=google-translate)](./README.md)

# PageTransformer
![Version](https://img.shields.io/badge/version-1.0.0--alpha-blue)
![License](https://img.shields.io/github/license/vejei/PageTransformer)
![Min SDK](https://img.shields.io/badge/minSdkVersion-21-informational)
![Last Commit](https://img.shields.io/github/last-commit/vejei/PageTransformer)

同时支持`ViewPager`和`ViewPager2`的`PageTransformer`

<p align="center" width="100%">
    <img width="24%" src="assets/cube_outside_transformer.gif">
    <img width="24%" src="assets/fan_transformer.gif">
    <img width="24%" src="assets/rotate_down_transformer.gif">
    <img width="24%" src="assets/zoom_in_transformer.gif">
</p>

## 快速开始
### 添加依赖
```groovy
dependencies {
    implementation 'io.github.vejei.pagetransformer:pagetransformer:x.y.z'
}
```

### 设置
如果不需要配置任何参数可以直接使用`SimplePageTransformer`，传入需要的 Transformer 名字：
```java
// ViewPager
ViewPager viewPager = view.findViewById(R.id.view_pager);
viewPager.setPageTransformer(false, new SimplePageTransformer(SimplePageTransformer.CUBE_INSIDE));

// ViewPager2
ViewPager2 viewPager = view.findViewById(R.id.view_pager2);
viewPager.setPageTransformer(new SimplePageTransformer(SimplePageTransformer.CUBE_INSIDE));
```

如果需要配置特定的参数，直接构建对应的 Transformer 对象：
```java
// ViewPager
ViewPager viewPager = view.findViewById(R.id.view_pager);
viewPager.setPageTransformer(false, new CubeInsideTransformer(20));

// ViewPager2
ViewPager2 viewPager = view.findViewById(R.id.view_pager2);
viewPager.setPageTransformer(new new CubeInsideTransformer(20));
```

详细的示例代码见[samples](./samples)

## 所有的`PageTransformerName`
`SimplePageTransformer`类所有可用的`PageTransformerName`目前有以下这些：
* `CUBE_INSIDE`
* `CUBE_OUTSIDE`
* `DEPTH`
* `FADE_SLIDE`
* `FADE`
* `FAN`
* `GATE`
* `ROTATE_DOWN`
* `ROTATE_UP`
* `ROTATE_HORIZONTAL`
* `ROTATE_VERTICAL`
* `SCALE`
* `SIDE_BY_SIDE`
* `STACK_BOTTOM`
* `STACK_TOP`
* `ZOOM_IN`
* `ZOOM_OUT`

## 所有的 Transformer
当前所有可用的 Transformer 包含以下这些：
* `CubeInsideTransformer`
* `CubeOutsideTransformer`
* `DepthTransformer`
* `FadeSlideTransformer`
* `FadeTransformer`
* `FanTransformer`
* `GateTransformer`
* `RotateDownTransformer`
* `RotateUpTransformer`
* `RotateHorizontalTransformer`
* `RotateVerticalTransformer`
* `ScaleTransformer`
* `SideBySideTransformer`
* `StackBottomTransformer`
* `StackTopTransformer`
* `ZoomInTransformer`
* `ZoomOutTransformer`

## 更新日志
[Change Log](./CHANGELOG.md)

## 开源许可
[MIT](./LICENSE)
