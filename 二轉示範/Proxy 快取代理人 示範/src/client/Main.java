package client;

import Factory.ServerFactoryImp;
import Proxy.Server;
import Util.Input;
import client.ServerTask.OnSearchFinishListener;

public class Main {
	private static Server server;
	private static OnSearchFinishListener listener;
	public static void main(String[] args) {
		server = new ServerFactoryImp().createServer();
		listener = new MyListener();
		askToInputName();
	}
	
	private static void askToInputName(){
		String name = Input.nextLine("輸入查詢商品：");
		ServerTask task = new ServerTask(server, name, listener);
		task.start();
	}
	
	private static class MyListener implements OnSearchFinishListener{
		
		@Override
		public void onError(Throwable err) {
			System.out.println(err.getMessage());
		}

		@Override
		public void onNext(String information) {
			System.out.println(information);
		}

		@Override
		public void onComplete() {
			askToInputName();
		}
		
	}

}
