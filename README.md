![](https://img.shields.io/badge/English-inactive?style=for-the-badge&logo=google-translate)
[![./README.zh.md](https://img.shields.io/badge/%E4%B8%AD%E6%96%87-informational?style=for-the-badge&logo=google-translate)](./README.zh.md)

# PageTransformer
![Version](https://img.shields.io/badge/version-1.0.0--alpha-blue)
![License](https://img.shields.io/github/license/vejei/PageTransformer)
![Min SDK](https://img.shields.io/badge/minSdkVersion-21-informational)
![Last Commit](https://img.shields.io/github/last-commit/vejei/PageTransformer)

The PageTransformer library which support `ViewPager` and `ViewPager2`.

## Quick Start
### Add dependency
```groovy
dependencies {
    implementation 'io.github.vejei.pagetransformer:pagetransformer:x.y.z'
}
```

### Set up
If you don't need any configuration use `SimplePageTransformer` directly, passing in the required transformer name.
```java
// ViewPager
ViewPager viewPager = view.findViewById(R.id.view_pager);
viewPager.setPageTransformer(false, new SimplePageTransformer(SimplePageTransformer.CUBE_INSIDE));

// ViewPager2
ViewPager2 viewPager = view.findViewById(R.id.view_pager2);
viewPager.setPageTransformer(new SimplePageTransformer(SimplePageTransformer.CUBE_INSIDE));
```

Or if you need any configuration, like the cube camera distance, construct the corresponding transformer object：
```java
// ViewPager
ViewPager viewPager = view.findViewById(R.id.view_pager);
viewPager.setPageTransformer(false, new CubeInsideTransformer(20));

// ViewPager2
ViewPager2 viewPager = view.findViewById(R.id.view_pager2);
viewPager.setPageTransformer(new new CubeInsideTransformer(20));
```

For detailed examples, see the [samples app](./samples).

## List of `PageTransformerName`
The all `PageTransformerName` of the `SimplePageTransformer` including:
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

## List of transformers
All currently available transformers including:
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

## Change Log
[Change Log](./CHANGELOG.md)

## License
[MIT](./LICENSE)
