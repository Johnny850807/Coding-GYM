package client;

import Exception.WebException;
import Factory.ServerFactory;
import Factory.ServerFactoryImp;
import Proxy.Server;
import Util.Input;

public class ServerTask extends Thread{
	private Server server;
	private String name;
	private OnSearchFinishListener listener;

	public ServerTask(Server server, String searchName, OnSearchFinishListener listener) {
		this.server = server;
		this.name = searchName;
		this.listener = listener;
	}
	
	@Override
	public void run() {
		String[] ids;
		try {
			String result = server.searchByName(name);
			if (result.trim().isEmpty())
				listener.onNext("查無結果");
			else
			{
				ids = result.split(",");
				for (String id : ids)
					listener.onNext(server.searchById(id));
			}
		}catch (Exception e) {
			listener.onError(e);
		}finally{
			listener.onComplete();
		}
	}
	
	public interface OnSearchFinishListener{
		public void onError(Throwable err);
		public void onNext(String information);
		public void onComplete();
	}

}
