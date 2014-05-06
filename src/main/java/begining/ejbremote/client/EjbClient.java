package begining.ejbremote.client;

import begining.ejbremote.lib.EjbInterface;
import begining.ejbremote.lib.EjbRemoteInterface;
import begining.ejbremote.lib.EjbUtil;

/**
 * Hello world!
 *
 */
public class EjbClient 
{
    private static final java.util.logging.Logger logger = 
    java.util.logging.Logger.getLogger(EjbClient.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logger.entering(EjbClient.class.getName(), "main");
        
        /***********************************************************************
         * Remoteアノテーションのみ付与しているEJBの呼び出し
         **********************************************************************/
        EjbInterface ejb = (EjbInterface) EjbUtil.ejbLookup(
                EjbUtil.EJB_BEAN_SERVICE);
        System.out.println(ejb.getName("Eiichi Tanaka"));
        
        /***********************************************************************
         * Local,Remoteの両方のアノテーションを付与したEJBをLookupをしたい場合は、
         * java:global/<アプリケーション名>/<モジュール名>/<Bean名>/<!完全修飾インターフェース名>
         * で、Lookupする必要あり
         **********************************************************************/
        EjbRemoteInterface ejb2 = (EjbRemoteInterface) EjbUtil.ejbLookup(
                EjbUtil.EJB_BEAN_SERVICE2 + "!" + EjbUtil.IF_SERVICE2_REMOTE);
        System.out.println(ejb2.getName("Eiichi Tanaka"));
        
        logger.exiting(EjbClient.class.getName(), "main");
    }
}
