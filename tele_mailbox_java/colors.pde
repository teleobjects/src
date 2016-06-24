String swatches[] = {"ffcc00", "4cd964", "34aadc", "007aff", "5856d6", "ff2d55", "8e8e93", "c7c7cc", "D1EEFC", "FFD3E0", "F7F7F7", "FF1300", "1F1F21", "BDBEC2", "FF3A2D"};
String gradients[][] = {{"ff5e3a", "ff2a68"}, {"ff9500", "ff5e3a"}, {"ffdb4c", "ffcd02"}, {"87fc70", "0bd318"}, {"52edc7", "5ac8fb"}, {"1ad6fd", "1d62f0"}, {"c644fc", "5856d6"}, {"ef4db6", "c643fc"}, {"4a4a4a", "2b2b2b"}, {"dbddde", "898c90"}, {"5ad427", "a4e786"}, {"c86edf", "e4b7f0"}, {"fb2b69", "ff5b37"}, {"f7f7f7", "d7d7d7"}, {"1d77ef", "81f3fd"}, {"d6cec3", "e4ddca"}, {"55efcb", "5bcaff"}};


color[] colors;
color[] tops;
color[] bottoms;

void initColors() {
	colors = new color[swatches.length];

	tops = new color[gradients.length];
	bottoms = new color[gradients.length];

	for (int i=0; i<swatches.length;i++) {
		colors[i] = unhex(swatches[i]);
	}
	for (int i=0; i<gradients.length;i++) {
		tops[i] = unhex(gradients[i][0]);
		bottoms[i] = unhex(gradients[i][1]);
	}
}