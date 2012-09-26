package com.ting.androidexample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ScrollView scrollView = new ScrollView(this);
		
		TextView textView = new TextView(this);
		textView.setText("“国庆”一词，本指国家喜庆之事，最早见于西晋。西晋的文学家陆机在" +
				"《五等诸侯论》一文中就曾有“国庆独飨其利，主忧莫与其害”的记载、我国封建时代、" +
				"国家喜庆的大事，莫大过于帝王的登基、诞辰（清朝称皇帝的生日为万岁节）等。因而我国" +
				"古代把皇帝即位、诞辰称为“国庆”。今天称国家建立的纪念日为国庆。在我国，国庆节特指中华" +
				"人民共和国正式宣告成立的10月1日。" + 
				"1949年10月1日，是新中国成立的纪念日。这里应该说明一点，" +
				"在许多人的印象中，1949年的10月1日  国庆宣传画在北京天安门广场举行了有数十" +
				"万军民参加的中华人民共和国开国大典。其实，人们头脑中的这一印象并不准确。因为，" +
				"1949年10月1日在天安门广场举行的典礼是中华人民共和国中央人民政府成立盛典，而不是" +
				"开国大典。实际上，中华人民共和国的“开国”，也就是说中华人民共和国的成立，早在当年10月1日" +
				"之前一个星期就已经宣布过了。当时也不叫“开国大典”，而是称作“开国盛典”。时间是1949年9月21日。" +
				"这一天，中国人民政治协商会议筹备会主任毛泽东在政协第一届会议上所致的开幕词中就已经宣告了" +
				"新中国的诞生。那么10月1日的国庆又是怎么回事呢？在中国人民政治协商会议第一届全国委员会第一次" +
				"会议上，鲁迅的夫人许广平委员发言说：“马叙伦委员请假不能来，他托我来说，中华人民共和国的成立，" +
				"应有国庆日，所以希望本会决定把10月1日定为国庆日。”毛泽东说“我们应作一提议，向政府建议，由政府" +
				"决定。”1949年10月2日，中央人民政府通过《关于中华人民共和国国庆日的决议》，规定每年10月1日为国庆" +
				"日，并以这一天作为宣告中华人民共和国成立的日子。从1950年起，每年的10月1日就成为全国各族人民隆重" +
				"欢庆的节日了。"
				);
		scrollView.addView(textView);
		
		setContentView(scrollView);
	}
}
