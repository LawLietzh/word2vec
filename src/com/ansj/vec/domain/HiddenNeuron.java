package com.ansj.vec.domain;
/**
 * 隐藏层
 * @author Administrator
 *
 */
public class HiddenNeuron extends Neuron{
    //隐藏到输出
    public double[] syn1 ; //hidden->out
    
    public HiddenNeuron(int layerSize){
        syn1 = new double[layerSize] ;
    }
    
}
