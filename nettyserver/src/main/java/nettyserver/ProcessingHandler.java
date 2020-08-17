package nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		RequestData requestData = (RequestData) msg;
		ResponseData responseData = new ResponseData();
		responseData.setIntValue(requestData.getIntValue() * 2);
		ChannelFuture future = ctx.writeAndFlush(responseData);
		future.addListener(ChannelFutureListener.CLOSE);
		System.out.println(requestData);
		
//		ByteBuf m = (ByteBuf) msg;
//		tmp.writeBytes(m);
//		m.release();
//		if (tmp.readableBytes() >= 4) {
//			// request processing
//			RequestData requestData = new RequestData();
//			requestData.setIntValue(tmp.readInt());
//			ResponseData responseData = new ResponseData();
//			responseData.setIntValue(requestData.getIntValue() * 2);
//			ChannelFuture future = ctx.writeAndFlush(responseData);
//			future.addListener(ChannelFutureListener.CLOSE);
//		}
	}
	
//	private ByteBuf tmp;

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		System.out.println("Handler added");
//		tmp = ctx.alloc().buffer(4);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		System.out.println("Handler removed");
//		tmp.release();
//		tmp = null;
	}
}