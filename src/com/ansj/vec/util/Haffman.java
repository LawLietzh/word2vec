package com.ansj.vec.util;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import com.ansj.vec.domain.HiddenNeuron;
import com.ansj.vec.domain.Neuron;

/**
 * 构建Haffman编码树
 * 
 * @author ansj
 *
 */
public class Haffman {
	// 特征数量
	private int layerSize;
	
	public Haffman(int layerSize) {
		this.layerSize = layerSize;
	}
	//只保存Haffman树的跟结点
	private TreeSet<Neuron> set = new TreeSet<>();
	/**
	 * 构建Huffman树
	 * @param neurons
	 */
	public void make(Collection<Neuron> neurons) {
		//有序的树集合
		set.addAll(neurons);
		//对TreeSet中元素进行合并，生成Haffman树
		while (set.size() > 1) {
			merger();
		}
	}
	/**
	 * 合并结点
	 */
	private void merger() {
		HiddenNeuron hn = new HiddenNeuron(layerSize);
		//弹出一个最小的
		Neuron min1 = set.pollFirst();
		//弹出一个次小的
		Neuron min2 = set.pollFirst();
		hn.category = min2.category;
		hn.freq = min1.freq + min2.freq;
		min1.parent = hn;
		min2.parent = hn;
		min1.code = 0;
		min2.code = 1;
		//压入结点
		set.add(hn);
	}

}
