package com.ansj.vec.domain;

/**
 * 必须实现Comparable接口，方便利用TreeSet有序树
 * 
 * @author Administrator
 *
 */
public abstract class Neuron implements Comparable<Neuron> {
	// 频率
	public double freq;
	//父结点
	public Neuron parent;
	//此结点的二叉树编码原子：0或者1
	public int code;
	// 语料预分类
	public int category = -1;

	@Override
	public int compareTo(Neuron neuron) {
		if (this.category == neuron.category) {
			if (this.freq > neuron.freq) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.category > neuron.category) {
			return 1;
		} else {
			return 0;
		}
	}
}
