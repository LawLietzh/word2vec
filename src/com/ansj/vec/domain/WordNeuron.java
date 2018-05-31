package com.ansj.vec.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WordNeuron extends Neuron {
	// 单词
	public String name;
	//输入到隐藏
	public double[] syn0 = null; // input->hidden
	//从根结点到此结点的路径
	public List<Neuron> neurons = null;// 路径神经元
	//单词编码
	public int[] codeArr = null;
	/**
	 * 生成路径神经元
	 * @return
	 */
	public List<Neuron> makeNeurons() {
		if (neurons != null) {
			return neurons;
		}
		Neuron neuron = this;
		neurons = new LinkedList<>();
		while ((neuron = neuron.parent) != null) {
			neurons.add(neuron);
		}
		//链表逆转
		Collections.reverse(neurons);
		codeArr = new int[neurons.size()];
		//记录到此结点的编码
		for (int i = 1; i < neurons.size(); i++) {
			codeArr[i - 1] = neurons.get(i).code;
		}
		codeArr[codeArr.length - 1] = this.code;

		return neurons;
	}

	public WordNeuron(String name, double freq, int layerSize) {
		this.name = name;
		this.freq = freq;
		this.syn0 = new double[layerSize];
		Random random = new Random();
		// 给每个特征赋个随机特征值
		for (int i = 0; i < syn0.length; i++) {
			syn0[i] = (random.nextDouble() - 0.5) / layerSize;
		}
	}

	/**
	 * 用于有监督的创造hoffman tree
	 * 
	 * @param name
	 * @param freq
	 * @param layerSize
	 */
	public WordNeuron(String name, double freq, int category, int layerSize) {
		this.name = name;
		this.freq = freq;
		this.syn0 = new double[layerSize];
		this.category = category;
		Random random = new Random();
		for (int i = 0; i < syn0.length; i++) {
			syn0[i] = (random.nextDouble() - 0.5) / layerSize;
		}
	}

}