package io.antmedia.plugin;

import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avformat.AVStream;

import io.antmedia.muxer.Muxer;
import io.vertx.core.Vertx;

public class PacketFeeder extends Muxer{

	public PacketFeeder(Vertx vertx) {
		super(vertx);
	}

	@Override
	public boolean addStream(AVCodec codec, AVCodecContext codecContext, int streamIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prepareIO() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeTrailer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePacket(AVPacket avpacket, AVStream inStream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePacket(AVPacket avpacket, AVCodecContext codecContext) {
		// TODO Auto-generated method stub
		
	}

}
